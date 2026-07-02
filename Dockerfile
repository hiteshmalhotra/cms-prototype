# ─────────────────────────────────────────────────────────────────────────────
# Stage 1 — Build
# ─────────────────────────────────────────────────────────────────────────────
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

# Copy wrapper + pom first (layer-cache friendly)
COPY .mvn/             .mvn/
COPY mvnw              mvnw
COPY pom.xml           pom.xml

# Download dependencies (cached unless pom.xml changes)
RUN ./mvnw dependency:go-offline -q

# Copy source and build the fat JAR
COPY src/ src/
RUN ./mvnw package -DskipTests -q

# ─────────────────────────────────────────────────────────────────────────────
# Stage 2 — Runtime
# ─────────────────────────────────────────────────────────────────────────────
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Non-root user for security
RUN addgroup -S cms && adduser -S cms -G cms
USER cms

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/cms-prototype-*.jar app.jar

# Render injects PORT env var at runtime; we pass it to Spring via SERVER_PORT
# Default 8090 for local Docker runs; Render overrides with its own PORT value
EXPOSE 8090

# Use shell form so ${PORT:-8090} is evaluated at container start
ENTRYPOINT ["sh", "-c", \
  "java -Djava.security.egd=file:/dev/./urandom -Dserver.port=${PORT:-8090} -jar app.jar"]
