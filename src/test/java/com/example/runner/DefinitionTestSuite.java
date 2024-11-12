package com.example.runner;




import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(glue = "com.example", features = "src/test/resources/features/", tags = "@Procedure")
//test SCQS88 with short prefix
//test SCQS83 with white port
//upload file test\resources\data\CPQ\SCQS68\SCQ68.ebx to /ebx_env/ebx_home/ebxRepository/archives to test SCQS68 and SCQS69

//@SCRP01,@SCRP02,@SCRP03,@SCRP04,@SCRP05,@SCRP06,@SCRP07,@SCRP08,@SCRP09
//@SCQS01,@SCQS02,@SCQS03,@SCQS04,@SCQS05,@SCQS06,@SCQS07,@SCQS09,@SCQS10,@SCQS11,@SCQS12,@SCQS13,@SCQS14,@SCQS15,@SCQS16,@SCQS17, @SCQS18,@SCQS19,@SCQS20, @SCQS21, @SCQS22,@SCQS23,@SCQS24,@SCQS25,@SCQS26,@SCQS28,@SCQS29,@SCQS30
public class DefinitionTestSuite {
}
