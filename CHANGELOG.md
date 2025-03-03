# Changelog
All notable changes to this project will be documented in this file.

## [0.1.0]
- Switch to using parent pom from rspace-os-parent project
- Compile with java 17
- Switch to 0.0.4 version of our rda-dmp-common-standard dependency

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.2.0]
- Renamed some of the methods in `DMPToolClient.java`
- Increased resilience for `DMPTool` JSONs response messages that contain fields that are not defined in the wrapper classes
- Made sure that the `DMPToolClient.java` fetches the plan from the `get` link (rather than `download` as it was)

## [0.2.1]
- Fix communication errors when post related identifiers