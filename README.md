# ContentProviders
ContentProvider example with two projects inside that are example for ContentProvider usage.

1 - App Project the Provider you will have to restart the app everytime you make a change to the Provider in order
to use it properly with the other projects.

2 - useProvider to show the data from the provider.

3 - Start first and then second project.

Okay what is a ContentProvider?

- A content provider is used to share the data from your App To Other apps if you have allowed them and gave them your URI.
- You can see this project to understand how they are used.

What is URI?

- Unified Resource Indentifier
 - It have tree parameters it is used to accessyour data
  - Scheme - "content://"
  - PackageOfProvider - "com.niki.provider"
  - TABLE, ROW, COLUMN depends what you are providing

How to make one?

- Well basicly create a DB Class with your data and tables
- Then Make a Provider class and extend the ContentProvider
- Then implement all six methods
- Rename properties in onCreate for better use
- Make your create Query with the builder
- For more info check the project there is some goodies inside.

ContentResoulver?

- Yes in order to use the Provider you will need a Resoulver that will allow you to communicate with the Provider.

ContentValues?

- Used to provide the data for the query

Cursor?

- Used as any normal Query you check if it exist then make a do/while move to first and go until there is no more rows.

Can't access the Provider?

- if you want to be accessable you will have to make it exported in order to do that go to AndroidManifest and make exported below
the provider to true.

- Add the name and the package of your provider below activities inside application.

Intresting?

- Just a hint here Exported option is available for Services and Broadcast Receivers too. You may check the official docs.

- ContentProvider is not available to use with Realm right now it will be supported in future.

- There are a couple ideas how to use ContentProvider with ORM but there are no available direct option so far - Sugar Object-relational mapping basicly converts incompatible types to compatible ones like for the example we have normal Java classes acting as SQL Tables. 

Wrap up?

- Well that is basicly everything about ContentProviders you can find more on the official page.

- Check out Android Dev page for more info on the topic.

#### Author

- Niki Izvorski (nikiizvorski@gmail.com)
