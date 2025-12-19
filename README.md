# CS-320-16581-M01-Software-Test

How can I ensure that my code, program, or software is functional and secure?
I ensure my software is functional and secure by writing thorough unit tests that directly align with the stated requirements. For the contact service, each requirement, such as unique IDs, field length limits, and non-null values, was translated into specific JUnit tests that verify both valid behavior and failure cases. By testing normal inputs alongside invalid and edge-case inputs, I was able to uncover errors early and confirm that the program behaves predictably under all conditions. This approach improves reliability and helps prevent unintended behavior, which is a key aspect of secure software development.

How do I interpret user needs and incorporate them into a program?
I interpret user needs by closely analyzing the requirements provided and treating them as the contract the software must fulfill. Instead of making assumptions, I used the requirements to guide both my implementation and my tests. Each rule defined by the customer became a validation check in the code and a corresponding unit test. This ensured that the software behaved exactly as expected from the user’s perspective and reduced the risk of misalignment between functionality and requirements.

How do I approach designing software?
I approach software design by breaking problems into small, manageable components and focusing on clarity and maintainability. I design classes with clear responsibilities and enforce constraints through constructors and controlled update methods. Testing is integrated into the design process rather than added at the end, which allows me to validate logic incrementally as I build. This mindset helps me produce software that is easier to test, easier to maintain, and more resilient to future changes.
