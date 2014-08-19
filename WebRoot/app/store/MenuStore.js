Ext.define('LSYS.store.MenuStore', {
	extend : 'Ext.data.TreeStore',
	autoLoad : true,
	model: 'LSYS.model.MenuModel',
	proxy : {
		type : 'ajax',
		url : '/listssys/service/getTreeListByList.json'
	},
    root: {
        expanded: true
    }
});