# Text-Repeater
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

A Simple Text Repeater Application written in java for Android


* Repeating text is easy now
* Repeat n times


## Screenshots
<img src="https://raw.githubusercontent.com/PonnamKarthik/TextRepeater/master/screenshots/screen_one.png" width="888">

<img src="https://raw.githubusercontent.com/PonnamKarthik/TextRepeater/master/screenshots/screen_one.png" width="888">

<img src="https://raw.githubusercontent.com/PonnamKarthik/TextRepeater/master/screenshots/screen_one.png" width="888">



## Getting started

#### Gradle Dependency (jcenter)

Easily reference the library in your Android projects using this dependency in your module's `build.gradle` file.

```java
dependencies {
    compile 'net.karthikponnam.textrepeater:library:1.0'
}
```


#### Basic 

## Syntax

```java
Repeater.repeat(CONTENT, COUNT);
```

##Example

```java
Repeater.repeat("text",5);
```

## Syntax

```java
Repeater.repeat(CONTENT, COUNT, BOOL_SPACES, BOOL_NEW_LINE, BOOL_OTHER_CHARACTER, OTHER_CHARACTER);

Repeater.repeat(String, int, boolean, boolean, boolean, String);
```

## Example 1

```java
Repeater.repeat("Android", 5, true, false, false, "");
```

```java
Android Android Android Android Android
```


## Example 2

```java
Repeater.repeat("Android", 5, false, true, false, "");
```

```java
Android
Android
Android
Android
Android
```

## Example 3

```java
Repeater.repeat("Android", 5, false, true, true, ":octocat:");
```

```java
Android :octocat:
Android :octocat:
Android :octocat:
Android :octocat:
Android :octocat:
```

## Working Example

* Please check the Sample Project

>   Thanks
>   Karthik Ponnam
