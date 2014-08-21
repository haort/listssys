Ext.define('LSYS.store.AdminTreeStore', {
	extend : 'Ext.data.TreeStore',
	autoLoad : true,
	model: 'LSYS.model.AdminTreeModel',
	proxy : {
		type : 'ajax',
		url : '/listssys/service/getAdminTreeList.json'
	},
    root: {
        expanded: true
    }
});