# Payment Management System  
A simple payment management system simulating purchases with multiple payment methods, including cryptocurrency, PayPal, credit card, and cash. The system validates payment amounts and handles custom exceptions for invalid payments.

## Purpose  
This is an educational project designed to review and reinforce concepts of generics and exceptions in Java.

## Features  
**Multiple Payment Methods**:  
- Cryptocurrency (PCripto): Pay with crypto. Requires email and wallet ID.  
- PayPal (PPayPal): Pay via PayPal. Requires email and PayPal account ID.  
- Credit Card (PTarjeta): Pay with a credit card. Requires card number and store ID.  
- Cash (PEfectivo): Pay with cash. Requires store ID and change amount.  

**Validation**: Ensures valid payments (no negative amounts or excess payments).  
**Custom Exception**: Handles invalid payments like expired credit cards.  
