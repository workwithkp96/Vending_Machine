Low-Level Design: Vending Machine

Welcome to the low-level design of a basic vending machine, built to simulate the core functionalities of a real-world vending system. This implementation is modular, flexible, and extensible, making it a great starting point for expanding into advanced features like payment systems, analytics, and more.

🛠️ Key Features
**Customizable Configuration:**
  Dynamically assign the number of shelves.
  Configure the number of racks in each shelf.
  Set the capacity (number of slots) for each rack.
  
**Item Management:**
  Add items to specific racks on selected shelves.
  Manage inventory seamlessly:
  Ensure racks don’t exceed capacity.
  Add items of the same type only to a rack.
  Remove items manually when required.
  
**Purchase Items:**
  Select the shelf and rack from which you want to purchase.
  Specify the quantity of the item.
  Automatically calculate the total cost based on the item price.
  Update inventory after a successful purchase.

**Inventory Display:**
  View the current state of the vending machine at any time.
  See the details of each shelf, rack, and the items stored in them.
  Empty racks are clearly labeled for easy identification.
📋 **Steps to Follow**
🧩 **Configure the Vending Machine:**

  Define the number of shelves in your vending machine.
  Specify the number of racks per shelf and their capacity.
📦 **Add Items:**

  Populate racks with items (e.g., Chips, Soda, Candy).
  Ensure the item fits within the available rack capacity.
  
🛒 **Buy Items:**

  Select the item you want to purchase by specifying the shelf and rack.
  Enter the quantity and confirm the purchase.
  The system calculates the total cost and automatically updates the inventory.
  
📊 **View Inventory:**

  Check the current state of the vending machine.
  Get a detailed breakdown of shelves, racks, items, and quantities.
  
🌟 **Design Highlights
🚀 Singleton Pattern:**

  The vending machine is implemented as a singleton to ensure only one instance exists throughout the application.

🔒 **Thread-Safe and Scalable:**
  The design is thread-safe and can easily be extended to support multi-user access or advanced features.

🎯 **Object-Oriented Design Principles:**
  The design follows core OOP principles (encapsulation, single responsibility, etc.) for maintainability and clarity:
  VendingMachine: Manages shelves, racks, and interactions.
  Shelf: Organizes racks within a vending machine.
  Rack: Manages storage for items.
  Item: Represents individual items with attributes like name and price.
  ⚡ **Extensibility:**
    Ready for additional features like:
    Payment integration.
    Item expiry tracking.
    Analytics for most-sold or low-stock items.
🛡️ **Error Handling:**
  Handles edge cases such as:
  Invalid shelf/rack selections.
  Adding items beyond rack capacity.
  Attempting to purchase unavailable items.
