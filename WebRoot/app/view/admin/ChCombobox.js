Ext.define('LSYS.view.admin.ChCombobox', {
    extend: 'Ext.form.ComboBox',
    alias : 'widget.chcobo',
    queryMode: 'local',
    displayField: 'chname',
    valueField: 'chname',
    store:'LSYS.store.ChComboboxStore'
});
