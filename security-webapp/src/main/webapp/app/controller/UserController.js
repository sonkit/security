/*
 * File: app/controller/UserController.js
 *
 * This file was generated by Sencha Architect version 2.2.2.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('Security.controller.UserController', {
    extend: 'Ext.app.Controller',

    models: [
        'User'
    ],
    stores: [
        'User'
    ],
    views: [
        'UserGrid',
        'UserWin',
        'UserPwdWin'
    ],

    refs: [
        {
            ref: 'userGrid',
            selector: 'usergrid'
        },
        {
            ref: 'userWin',
            selector: 'userwin'
        },
        {
            ref: 'userPwdWin',
            selector: 'userpwdwin'
        }
    ],

    onActioncolumnClick: function(grid, cell, row, col, e, eOpts) {
        var rec = grid.getStore().getAt(row),
            action = e.target.getAttribute('class');

        this.getUserGrid().getSelectionModel().select(rec);

        if (action.indexOf("x-action-col-0") != -1) {
            this.editUser(e);
        } else if (action.indexOf("x-action-col-1") != -1) {
            this.deleteUser();
        } else if (action.indexOf("x-action-col-2") != -1) { 
            this.modifyUserPassword(e);
        }
    },

    userRoleMgr: function(button, e, eOpts) {

        var tabs = Ext.ComponentQuery.query('viewport > tabpanel').pop(),
            userrolepanel = tabs.child('userrolepanel');

        if (!userrolepanel) {
            this.getController('UserRoleController');
            userrolepanel = tabs.add(Ext.widget('userrolepanel'))
        }
        tabs.setActiveTab(userrolepanel);

    },

    saveUserNewPwd: function(button, e, eOpts) {
        var win = this.getUserPwdWin(),
            form = win.child('form');

        if (form.isValid()) {
            var userId = form.getForm().findField('id').getValue(),
                pwd1 = form.getForm().findField('pwd1').getValue(),
                pwd2 = form.getForm().findField('pwd2').getValue();

            if (pwd1 != pwd2) {
                Ext.example.msg('提示', '两次输入的密码不一致，请改正！');
                return;
            }

            Ext.Ajax.request({
                url: 'users/modifyPassword',
                method: 'PUT',
                params: {
                    userId: userId,
                    password: pwd1
                },
                success: function(response, opts) {
                    win.close();
                }
            });
        }
    },

    addUser: function(button, e, eOpts) {
        Ext.widget('userwin').show(button);
    },

    saveUser: function(button, e, eOpts) {
        var userWin = this.getUserWin(),
            userGrid = this.getUserGrid(),
            form = userWin.child('form');

        if (form.isValid()) {
            var user = Ext.create('Security.model.User', form.getValues());
            user.set('orga', {id: form.getForm().findField('orga.id').getValue()});
            user.save({
                success: function() {
                    userGrid.getSelectionModel().deselectAll();
                    userGrid.getStore().reload();
                    userWin.close();
                }
            });
        }

    },

    editUser: function(e) {
        var userWin = Ext.widget('userwin'),
            record = this.getUserGrid().getSelectionModel().getLastSelected(),
            form = userWin.child('form');

        form.loadRecord(record);
        form.getForm().findField('password').hide();
        form.getForm().findField('orga.id').setValue(record.get('orga').id);

        userWin.show(e.target);
    },

    deleteUser: function() {
        var selModel = this.getUserGrid().getSelectionModel(),
            userStore = this.getUserStore();

        Ext.Msg.confirm('确认', '您确定要删除吗?', function(buttonId) {
            if (buttonId == 'yes') {
                var record = selModel.getLastSelected();
                Ext.create('Security.model.User', {
                    id: record.get('id')
                }).destroy({
                    success: function() {
                        userStore.reload();
                    }
                });
            }
        });
    },

    modifyUserPassword: function(e) {
        var userStore = this.getUserStore(),
            win = Ext.widget('userpwdwin'),
            form = win.child('form').getForm(),
            user = this.getUserGrid().getSelectionModel().getLastSelected();

        form.findField('id').setValue(user.get('id'));
        form.findField('username').setValue(user.get('username'));

        win.show(e.target);

    },

    init: function(application) {
        this.control({
            "actioncolumn": {
                click: this.onActioncolumnClick
            },
            "usergrid button[text='用户授权']": {
                click: this.userRoleMgr
            },
            "userpwdwin button[text='保存']": {
                click: this.saveUserNewPwd
            },
            "usergrid button[text='添加']": {
                click: this.addUser
            },
            "userwin button[text='保存']": {
                click: this.saveUser
            }
        });
    }

});
