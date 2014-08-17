Ext.define('LSYS.model.PieModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.reader.Json'
    ],
    fields: [
             {
                 name: 'state'
             },
             {
                 name: 'count'
             }
         ]
});