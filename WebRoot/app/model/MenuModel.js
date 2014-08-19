Ext.define('LSYS.model.MenuModel', {
    extend: 'Ext.data.Model',
    fields: [
     {name:'id',type:'string'},
     {name:'text',type:'string'},
     {name:'leaf',type:'boolean',defaultValue:true},
     {name:'description',type:'string'}
    ]
});