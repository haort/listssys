Ext.define('LSYS.view.admin.AdminComboboxView', {
    extend: 'Ext.form.ComboBox',
    alias : 'widget.adminarea',
    queryMode: 'local',
    displayField: 'name',
    valueField: 'area',
    emptyText: '选择区域...',
    store:'LSYS.store.AdminComboboxStore'
});
