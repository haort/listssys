Ext.define('LSYS.view.admin.AdminComboboxView', {
    extend: 'Ext.form.ComboBox',
    alias : 'widget.admincoboview',
    queryMode: 'local',
    displayField: 'name',
    valueField: 'authority',
    emptyText: '选择权限...',
    store:'LSYS.store.AdminComboboxStore'
});
