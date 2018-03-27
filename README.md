BruteForce4J
============

[BruteForce][bruteforce] a Zip archive protected with a password using a [Dictionnary][seclist].

Install
-------

Clone this reprository & build project using [Maven][maven].

~~~bash
$ git clone https://github.com/madeindjs/BruteForce4Zip.git
$ cd BruteForce4Zip
$ mvn package
~~~

Usage
-----

~~~bash
$ java -jar target/BruteForce4Zip-1.0-SNAPSHOT-jar-with-dependencies.jar ~/Download/archive.zip
~~~

[bruteforce]: https://en.wikipedia.org/wiki/Brute-force_attack
[seclist]: https://github.com/danielmiessler/SecLists/tree/master/Passwords
[maven]: http://maven.apache.org/