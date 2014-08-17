Ext.define('LSYS.store.PieStore', {
    extend: 'Ext.data.Store',

    requires: [
        'Ext.data.proxy.Ajax',
        'Ext.data.Field'
    ],
    model: 'LSYS.model.PieModel'
});