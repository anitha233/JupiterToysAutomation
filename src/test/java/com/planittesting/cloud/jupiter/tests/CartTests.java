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
     *
     * Expected Result:
     *  * 1. Products appear in the cart with correct quantities:
     *  *    - Stuffed Frog → Quantity: 2
     *  *    - Fluffy Bunny → Quantity: 5
     *  *    - Valentine Bear → Quantity: 3
     *  *
     *  * 2. Unit prices are displayed correctly:
     *  *    - Stuffed Frog → $10.99
     *  *    - Fluffy Bunny → $9.99
     *  *    - Valentine Bear → $14.99
     *  *
     *  * 3. Subtotals are calculated as Quantity × Unit Price:
     *  *    - Stuffed Frog → 2 × 10.99 = $21.98
     *  *    - Fluffy Bunny → 5 × 9.99 = $49.95
     *  *    - Valentine Bear → 3 × 14.99 = $44.97
     *  *
     *  * 4. Total amount equals the sum of all subtotals:
     *  *    $21.98 + $49.95 + $44.97 = $116.90
     *  *
     *  * 5. All prices are displayed with two decimal places and a dollar sign ($).
     *  * 6. No calculation or display errors should be present in the cart.
	 */

	@Test(priority =3)
	public void testcase3_VerifyCartTotals() {
	HomePage home = new HomePage(driver);
	 home.goToShopPage();
	 
	 //Navigating to shop page
	 ShopPage shop = new ShopPage(driver);
	 

     // Add products to cart
     shop.buyProduct("Stuffed Frog",2);
     shop.buyProduct("Fluffy Bunny",5);
     shop.buyProduct("Valentine Bear",3);

     // Go to cart
     shop.goToCart();
   

        CartPage cart = new CartPage(driver);
        int frogQty = cart.getProductQuantity("Stuffed Frog");
        System.out.println("Stuffed Frog Quantity: " + frogQty);


        // Get product prices from Shop page
        double frogPrice = shop.getProductPrice("Stuffed Frog");
        double bunnyPrice = shop.getProductPrice("Fluffy Bunny");
        double bearPrice = shop.getProductPrice("Valentine Bear");

        // Validate prices in cart
        Assert.assertEquals(cart.getProductPrice("Stuffed Frog"), frogPrice, "Stuffed Frog price mismatch!");
        Assert.assertEquals(cart.getProductPrice("Fluffy Bunny"), bunnyPrice, "Fluffy Bunny price mismatch!");
        Assert.assertEquals(cart.getProductPrice("Valentine Bear"), bearPrice, "Valentine Bear price mismatch!");

        // Validate subtotals
        Assert.assertEquals(cart.getProductSubtotal("Stuffed Frog"), frogPrice * 2, "Stuffed Frog subtotal mismatch!");
        Assert.assertEquals(cart.getProductSubtotal("Fluffy Bunny"), bunnyPrice * 5, "Fluffy Bunny subtotal mismatch!");
        Assert.assertEquals(cart.getProductSubtotal("Valentine Bear"), bearPrice * 3, "Valentine Bear subtotal mismatch!");

        // Validate total
        double expectedTotal = (frogPrice * 2) + (bunnyPrice * 5) + (bearPrice * 3);
        Assert.assertEquals(cart.getTotal(), expectedTotal, "Cart total mismatch!");
    }


 }

