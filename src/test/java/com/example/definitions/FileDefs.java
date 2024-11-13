package com.example.definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.io.File;

public class FileDefs {
    static int numberFilesDownload = 0;
    @And("^I get number file of folder dowload$")
    public void iGetNumberFileOfFolderDowload() {
        File file = new File("src/test/download");
        if(file.exists())
        {
           numberFilesDownload = file.list().length;
        }
    }

    @Then("^I verify file download completed$")
    public void iVerifyFileDownloadCompleted() throws InterruptedException {
        int countTimeCheck = 0;
        File file = new File("src/test/download");
       do {
           countTimeCheck++;
           Thread.sleep(4000);
           System.out.println("numberFilesDownload:"+numberFilesDownload +" number files "+file.list().length);
       }while ((!file.exists()||numberFilesDownload!=file.list().length-1)&&countTimeCheck<5);
        Assert.assertTrue(countTimeCheck<5);
    }
}
