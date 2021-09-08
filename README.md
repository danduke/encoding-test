The purpose of this project is to demonstrate an encoding problem introduced in grails 4.0.4.

In general, this is a blank application using all defaults.  It was created with `grails create-app`.

### Important files
* [index.gsp](https://github.com/danduke/encoding-test/blob/master/grails-app/views/index.gsp) - This should output "Test(line break)String"
* [gradle.properties](https://github.com/danduke/encoding-test/blob/master/gradle.properties) - Change version from 4.0.3 to 4.0.4 to reproduce problem
* [DemoCodec](https://github.com/danduke/encoding-test/blob/master/grails-app/utils/encoding/test/DemoCodec.groovy) - A simple codec that outputs HTML
* [application.yml](https://github.com/danduke/encoding-test/blob/master/grails-app/conf/application.yml) - Sets default output encoding around line 78

### General Approach
Change grails version in gradle.properties.  No other changes are needed.

#### grails-4.0.3
* Run the application with `run-app` and note that the index page shows "Test(line break)String" on two lines.  The HTML output from the codec is not encoded.
* Run gradle tasks `clean` (just to be sure) and `assemble`.  Run the resulting jar.  Note that the index page shows the same thing as before.

#### grails-4.0.4
* Same output from `run-app`
* When using `clean`, `assemble`, and running the resulting jar, the index page output shows the text "Test&lt;br/&gt;String" with the HTML encoded.
 
