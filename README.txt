Buildtime Extension
---------------------

Outputs to the console how long the different maven plugins take to execute

To use, add this to your parent POM:

<build>
  <extensions>
    <extension>
      <groupId>no.bekk.bekkopen</groupId>
      <artifactId>buildtime-maven-extension</artifactId>
      <version>1.0-SNAPSHOT</version>
    </extension>
  </extensions>
</build>

