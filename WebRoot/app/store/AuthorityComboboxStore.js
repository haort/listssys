Ext.define('LSYS.store.AuthorityComboboxStore', {
    extend: 'Ext.data.Store',
    fields: ['name', 'authority'],
    data : [
        {"name":"管理员", "authority":"admin"},
        {"name":"普通", "authority":"normal"}
    ]
});