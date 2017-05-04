Buildtime Extension
---------------------

Outputs to the console how long the different maven plugins take to execute

To use it, _mvn clean install_, and add this to your parent POM:

<build>
  <extensions>
    <extension>
      <groupId>no.bekk.bekkopen</groupId>
      <artifactId>buildtime-maven-extension</artifactId>
      <version>3.5.0</version>
    </extension>
  </extensions>
</build>

Works with maven 3.5.0, but can easily be adapted to work with other versions as well.

