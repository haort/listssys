Ext.define('LSYS.view.admin.AreaCombobox', {
    extend: 'Ext.form.ComboBox',
    alias : 'widget.areacobo',
    queryMode: 'local',
    displayField: 'area',
    valueField: 'area',
    store:'LSYS.store.AreaComboboxStore'
});
