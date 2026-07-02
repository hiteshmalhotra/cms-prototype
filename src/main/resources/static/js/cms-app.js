/* ============================================================
   CMS Enterprise App — cms-app.js
   ============================================================ */

(function () {
  'use strict';

  /* ── Sidebar toggle ─────────────────────────────── */
  const toggleBtn = document.getElementById('sidebarToggle');
  const shell = document.querySelector('.cms-shell');

  if (toggleBtn && shell) {
    toggleBtn.addEventListener('click', () => {
      if (window.innerWidth <= 768) {
        const sidebar = document.querySelector('.cms-sidebar');
        sidebar && sidebar.classList.toggle('mobile-open');
      } else {
        shell.classList.toggle('sidebar-collapsed');
        localStorage.setItem('sidebar-collapsed', shell.classList.contains('sidebar-collapsed'));
      }
    });

    // Restore saved state
    if (localStorage.getItem('sidebar-collapsed') === 'true') {
      shell.classList.add('sidebar-collapsed');
    }
  }

  /* ── Active nav detection ───────────────────────── */
  const path = window.location.pathname;
  document.querySelectorAll('.sidebar-link').forEach(link => {
    const href = link.getAttribute('href');
    if (href && path.startsWith(href) && href !== '/') {
      link.classList.add('active');
      // expand parent submenu
      const sub = link.closest('.collapse');
      if (sub) {
        sub.classList.add('show');
        const trigger = document.querySelector(`[data-bs-target="#${sub.id}"]`);
        if (trigger) trigger.setAttribute('aria-expanded', 'true');
      }
    }
  });

  /* ── Toast helper ───────────────────────────────── */
  window.cmsToast = function (message, type = 'success') {
    const icons = { success: 'bi-check-circle-fill', danger: 'bi-x-circle-fill', warning: 'bi-exclamation-triangle-fill', info: 'bi-info-circle-fill' };
    const colors = { success: 'text-success', danger: 'text-danger', warning: 'text-warning', info: 'text-primary' };
    const container = document.querySelector('.cms-toast-container') || (() => {
      const c = document.createElement('div');
      c.className = 'cms-toast-container';
      document.body.appendChild(c);
      return c;
    })();

    const toast = document.createElement('div');
    toast.className = 'toast cms-toast align-items-center border-0 mb-2 show';
    toast.innerHTML = `
      <div class="d-flex align-items-center p-3 gap-2">
        <i class="bi ${icons[type] || icons.info} ${colors[type] || ''} fs-5"></i>
        <div class="flex-1">${message}</div>
        <button type="button" class="btn-close ms-auto" data-bs-dismiss="toast"></button>
      </div>`;
    container.appendChild(toast);

    const bsToast = new bootstrap.Toast(toast, { delay: 3500 });
    bsToast.show();
    toast.addEventListener('hidden.bs.toast', () => toast.remove());
  };

  /* ── Confirm dialog helper ──────────────────────── */
  window.cmsConfirm = function (message, onConfirm) {
    const existing = document.getElementById('cmsConfirmModal');
    if (existing) existing.remove();

    const modal = document.createElement('div');
    modal.className = 'modal fade';
    modal.id = 'cmsConfirmModal';
    modal.innerHTML = `
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title"><i class="bi bi-exclamation-triangle me-2"></i>Confirm Action</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
          <div class="modal-body py-4">${message}</div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary btn-sm" data-bs-dismiss="modal">Cancel</button>
            <button type="button" class="btn btn-danger btn-sm" id="cmsConfirmOk">Confirm</button>
          </div>
        </div>
      </div>`;
    document.body.appendChild(modal);

    const bsModal = new bootstrap.Modal(modal);
    bsModal.show();
    document.getElementById('cmsConfirmOk').addEventListener('click', () => {
      bsModal.hide();
      if (typeof onConfirm === 'function') onConfirm();
    });
  };

  /* ── Delete confirmation links ──────────────────── */
  document.querySelectorAll('[data-confirm]').forEach(el => {
    el.addEventListener('click', function (e) {
      e.preventDefault();
      const msg = this.getAttribute('data-confirm') || 'Are you sure you want to delete this record? This action cannot be undone.';
      const href = this.getAttribute('href') || this.getAttribute('data-href');
      cmsConfirm(msg, () => { if (href) window.location.href = href; });
    });
  });

  /* ── Form submit feedback ───────────────────────── */
  document.querySelectorAll('form[data-toast]').forEach(form => {
    form.addEventListener('submit', function () {
      const msg = this.getAttribute('data-toast');
      setTimeout(() => cmsToast(msg), 400);
    });
  });

  /* ── Auto-show success param toast ─────────────── */
  const params = new URLSearchParams(window.location.search);
  if (params.get('saved') === 'true')   cmsToast('Record saved successfully.');
  if (params.get('deleted') === 'true') cmsToast('Record deleted successfully.', 'danger');
  if (params.get('sent') === 'true')    cmsToast('Sent successfully.');
  if (params.get('approved') === 'true') cmsToast('Approved successfully.', 'success');
  if (params.get('rejected') === 'true') cmsToast('Record rejected.', 'warning');
  if (params.get('changed') === 'true') cmsToast('Password changed. Please log in.', 'info');
  if (params.get('logout') === 'true')  cmsToast('You have been logged out.', 'info');

  /* ── Tooltip init ───────────────────────────────── */
  document.querySelectorAll('[data-bs-toggle="tooltip"]').forEach(el => {
    new bootstrap.Tooltip(el);
  });

})();
