Ext.define('LSYS.view.ComboboxView', {
    extend: 'Ext.form.ComboBox',
    alias : 'widget.coboview',
    fieldLabel: '选择状态',
    queryMode: 'local',
    displayField: 'sname',
    valueField: 'state',
    store:'LSYS.store.ComboboxStore'
});