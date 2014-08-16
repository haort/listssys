Ext.define('LSYS.store.MenuStore', {
	extend : 'Ext.data.TreeStore',
	proxy : {
		type : 'ajax',
		url : '/listssys/json/getTreeList.json'
	}
});