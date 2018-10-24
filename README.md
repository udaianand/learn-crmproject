# learn-crmproject
Practical implementation of realtime scenarios on FreeCRM Application

#Page Object Model Design Pattern

#Base Classes:
#TestBase.java -
  Used to Load properties file.
  Used to initialize driver and open url.

#PageBase.java -
  This is used for the accessing the webelements that are common to all the pages except login page.
  Elements in menu bar such as Deals, Tasks, Contacts, etc., and the web elements in the left side are available across all the pages.
