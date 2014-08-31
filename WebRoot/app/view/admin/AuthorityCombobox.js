Ext.define('LSYS.view.admin.AuthorityCombobox', {
    extend: 'Ext.form.ComboBox',
    alias : 'widget.admincoboview',
    queryMode: 'local',
    displayField: 'name',
    valueField: 'authority',
    store:'LSYS.store.AuthorityComboboxStore'
});
