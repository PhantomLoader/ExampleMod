
# Phantom Loader example mod

This example shows how a mod can be created using Phantom Loader.

Refer to the [wiki](https://github.com/PhantomLoader/PhantomLoader/wiki) for a full explanation.

## Build scripts

Phantom Loader uses an annotation processor to generate code for specific mod loaders without requiring the mod developer to add code in the mod loader's module.

```groovy
// Forge
implementation fg.deobf("curse.maven:phantom-loader-958545:5011993")
annotationProcessor fg.deobf("curse.maven:phantom-loader-958545:5011993")
annotationProcessor "io.github.phantomloader:processor-forge:${phantomVersion}"
// Fabricì
modImplementation "curse.maven:phantom-loader-958545:5011988"
annotationProcessor "curse.maven:phantom-loader-958545:5011988"
annotationProcessor "net.fabricmc:fabric-loader:${fabricVersion}"
annotationProcessor "io.github.phantomloader:processor-fabric:${phantomVersion}"
```

Methods annotated with `@ModEntryPoint` will be called from the generated classes for the respective loader.

```java
public class ExampleMod {

    @ModEntryPoint
    public static void initialize() {
        // ...
    }
}
```

The above will generate the following:

```java
// Forge
@Mod("example")
public class ForgeInitializer {

    public ForgeInitializer() {
        ExampleMod.initialize();
    }
}
```

```java
// Fabric
public class FabricInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        ExampleMod.initialize();
    }
}
```
