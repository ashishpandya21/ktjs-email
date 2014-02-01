/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function WebmailViewModel() {
    // Data
    var self = this;
    self.folders = ['Inbox', 'Archive', 'Sent', 'Spam'];
    
    self.chosenFolderId = ko.observable();
    self.chosenFolderData = ko.observable();
    self.chosenMailData = ko.observable();

    // Behaviours
    self.goToFolder = function(folder) { 
        self.chosenFolderId(folder);
        self.chosenMailData(null); // Stop showing a mail

        $.get('mail/index', { folder: folder }, self.chosenFolderData);
    };

    self.goToMail = function(mail) { 
        self.chosenFolderId(mail.folder);
        self.chosenFolderData(null); // Stop showing a folder
        $.get("mail/mailDetails", { id: mail.id }, self.chosenMailData);
    };

    self.goToFolder('Inbox');
};

ko.applyBindings(new WebmailViewModel());