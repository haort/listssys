Ext.define('LSYS.view.ComboboxView', {
    extend: 'Ext.form.ComboBox',
    alias : 'widget.coboview',
    queryMode: 'local',
    displayField: 'sname',
    valueField: 'state',
    store:'LSYS.store.ComboboxStore'
});