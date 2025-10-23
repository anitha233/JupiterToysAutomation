package com.planittesting.cloud.jupiter.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.planittesting.cloud.jupiter.pages.CartPage;
import com.planittesting.cloud.jupiter.pages.HomePage;
import com.planittesting.cloud.jupiter.pages.ShopPage;
import com.planittesting.cloud.jupiter.utils.BaseTest;

public class CartTests extends BaseTest{
	
	/**
	 * Test Case 3: Verify Cart Calculations for Multiple Products
	 *
	 * Steps:
	 * 1. Navigate to the Shop Page from the Home Page.
	 * 2. Add the following products to the cart:
	 *    - 2 x Stuffed Frog
	 *    - 5 x Fluffy Bunny
	 *    - 3 x Valentine Bear
	 * 3. Navigate to the Cart Page.
	 * 4. Verify that the subtotal for each product is correctly calculated 
	 *    as Quantity x Unit Price.
	 * 5. Verify that the unit price for each product is displayed correctly.
	 * 6. Verify that the total amount in the cart equals the sum of all subtotals.
	 */

	@Test(priority =3)
	public void testcase3_VerifyCartTotals() {
	HomePage home = new HomePage(driver);
	 home.goToShopPage();
	 
	 
	 ShopPage shop = new ShopPage(driver);
	 

     // Add products to cart
     shop.buyStuffedFrog(2);
     shop.buyFluffyBunny(5);
     shop.buyValentineBear(3);

     // Go to cart
     shop.goToCart();
   
     CartPage cart = new CartPage(driver);
     
     // Verify each product subtotal
     verifyProductSubtotal(cart, "Stuffed Frog");
     verifyProductSubtotal(cart, "Fluffy Bunny");
     verifyProductSubtotal(cart, "Valentine Bear");

     double total = cart.getTotal();
     double calculatedTotal = cart.getSubtotal("Stuffed Frog") + cart.getSubtotal("Fluffy Bunny") + cart.getSubtotal("Valentine Bear");

     Assert.assertEquals(total, calculatedTotal, "Total should be equal to the sum of all subtotals");
 }

 private void verifyProductSubtotal(CartPage cart, String productName) {
     double price = cart.getPrice(productName);
     int quantity = cart.getQuantity(productName);
     double expectedSubtotal = price * quantity;
     double actualSubtotal = cart.getSubtotal(productName);

     Assert.assertEquals(actualSubtotal, expectedSubtotal, "Subtotal for " + productName + " should be correct");
 }
}
