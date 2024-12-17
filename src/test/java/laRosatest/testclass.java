package laRosatest;


import org.testng.annotations.Test;

import larosa.Baseclasslarosa;
import larosa.pageclass;


public class testclass extends Baseclasslarosa
{
@Test
public void testlarosa()
{
pageclass ro =new pageclass(driver);
ro.titleVerification();
ro.linkcount();
ro.pagesource();
ro.search();
ro.searchbuttonclick();
ro.accountCreation();
ro.setValues("asde", "febzasde129@gmail.com", "9778204256");
ro.navigateHome();
ro.newArrivals();
ro.SelectAdress();
ro.AddToCart();
ro.navigateHome();
ro.myCart();
}
}
