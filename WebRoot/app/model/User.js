Ext.define('LSYS.model.User', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.reader.Json'
    ],

    fields: ['id', 'name','phone', 'addr','acc','area','startdt','enddt']
});