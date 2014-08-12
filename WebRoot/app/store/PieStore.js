Ext.define('LSYS.store.PieStore', {
    extend: 'Ext.data.Store',

    requires: [
        'Ext.data.proxy.Ajax',
        'Ext.data.Field'
    ],
    model: 'LSYS.model.PieModel',
    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            autoLoad: true,
            autoSync: true,
            proxy: {
                type: 'ajax',
                url: 'data/pie.json',
                reader: {
                    type: 'json',
                    root: 'pies',
                }
            }
           
        }, cfg)]);
    }
});