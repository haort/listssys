Ext.define('LSYS.view.admin.AdminUserManager', {
    extend: 'Ext.window.Window',
    alias : 'widget.adminusermanager',
    layout: 'hbox',
    autoShow: true,
    title: '用户管理',
    width: 800,
    height:500,
    frame: true,
    modal : true,
    initComponent: function(){
    var group = this.id + '-ddgroup';
    
    Ext.apply(this, {
        items: [{
            title: '用户清单',
            xtype: 'treepanel',
            store:'LSYS.store.AdminUserTreeStore',
            rootVisible : false,
        	lines : false,
        	useArrows : true,
            viewConfig:{
        		plugins:{
        	        ptype:'treeviewdragdrop',
        	        enableDrag:true,
        	        enableDrop:true,
        	        appendOnly:true
			    },
			    listeners: {
			    	drop:function(node,data,overModel,dropPosition,options){
				        Ext.Ajax.request({
			                url: '/listssys/service/updateUserParentId.json',
			                params: {selectId: data.records[0].get('uid'), tagertId: overModel.get("uid"),targetDeep:overModel.get('deep')},
			                method: 'Post',
			                success: function (response, options) {
			                },
			                failure: function (response, options) {
			                }
			            });
			       }
			    }
            },
            
            margin: '5 0 5 5',
            flex: 1
        }, {
            title: '用户信息',
            xtype: 'form',
            bodyPadding: 10,
            items:[{
                xtype: 'fieldset',
                title: '登录信息',
                defaultType: 'textfield',
                defaults: {
                    anchor: '100%'
                },
                items: [
                    { fieldLabel: '用户ID', name: 'uid',hidden:true},
                    { allowBlank:false, fieldLabel: '登录名', name: 'userName'},
                    { allowBlank:false, fieldLabel: '密码', name: 'password', inputType: 'password' }
                ]
            },
            {
                xtype: 'fieldset',
                title: '基本信息',
                defaultType: 'textfield',
                defaults: {
                    anchor: '100%'
                },
                items: [{
                    fieldLabel: '用户名',
                    name: 'name',
                    allowBlank:false
                },
                {
                    fieldLabel: '部门',
                    name: 'departMent',
                    allowBlank:false
                },
                {
                    fieldLabel: '所属区域',
                    name: 'area',
                    xtype: 'areacobo',
                    editable:true,
                    allowBlank:true
                },
                {
                    xtype: 'chcobo',
                    fieldLabel: '所属营业厅',
                    name: 'chName',
                    editable:true,
                    allowBlank:true
                },
                {
                    xtype: 'admincoboview',
                    fieldLabel: '权限',
                    name: 'authority',
                    editable:false,
                    allowBlank:false
                }]
            }],
            buttons: [
			{
			    text: '删除',
			    action:'delete'
			},
            {
                text: '修改',
                action:'modify'
            },{
                text: '保存',
                disabled: true,
                formBind: true,
                action:'save'
            },
            {
                text: '重置',
                action:'reset'
            }],
            margin: '5 5 5 5',
            flex: 1
            
        }]
    });
    this.callParent();
}
});