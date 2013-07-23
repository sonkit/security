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
        'UserGridPanel',
        'UserWin'
    ],

    refs: [
        {
            ref: 'userGrid',
            selector: 'usergrid'
        },
        {
            ref: 'userWin',
            selector: 'userwin'
        }
    ],

    deleteUser: function(button, e, eOpts) {
        var selModel = this.getUserGrid().getSelectionModel(),
            userStore = this.getUserStore();

        if (selModel.hasSelection()) {
            var record = selModel.getLastSelected();
            Ext.create('Security.model.User', {
                id: record.get('id')
            }).destroy({
                success: function() {
                    userStore.reload();
                }
            })
        }
    },

    editUser: function(button, e, eOpts) {
        var userWin = Ext.widget('userwin'),
            userGrid = this.getUserGrid()
            selModel = userGrid.getSelectionModel();

        if (selModel.hasSelection()) {

            var record = selModel.getLastSelected(),
                form = userWin.child('form');

            form.loadRecord(record);
            userWin.show(button);
        }


    },

    addUser: function(button, e, eOpts) {
        var win = Ext.widget('userwin');
        win.show(button);
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
                    userGrid.getStore().reload();
                    userWin.close();
                }
            });
        }

    },

    init: function(application) {
        this.control({
            "usergrid button[text='删除']": {
                click: this.deleteUser
            },
            "usergrid button[text='编辑']": {
                click: this.editUser
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