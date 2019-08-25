# Duct services.google-api

TODO: CI
[![Build Status](https://travis-ci.org/agrison/duct-mongodb.svg?branch=master)](https://travis-ci.org/agrison/duct-mongodb)

[Integrant][] methods for connecting to a [Google API][] database via
[google-api-clj][].

[integrant]: https://github.com/weavejester/integrant
[Google API]: https://developers.google.com/api-client-library/java/google-api-java-client/dev-guide
[google-api-clj]: https://github.com/viebel/google-api-clj

## Installation

To install, add the following to your project `:dependencies`

    [viebel/duct-google-api "0.1.0"]

## Usage

This library provides three things: 
and the selected database (`:db`).
* a multimethod for `:duct.services.google/drive` that initiates the Drive service based on either google client or credetials path.
* a multimethod for `:duct.services.google/sheets` that initiates the Sheets service based on either google client or credetials path.
* a multimethod for `:duct.services.google/client` 
that initiates the google client based on credetials path.


## Connection settings

### Credentials Path

For Drive service:

```edn
{:duct.services.google/drive
  {:credentials-path "my-creds.json"}
```

For Sheets service:

```edn
{:duct.services.google/drive
  {:credentials-path "my-creds.json"}
```

### Google Client

When you need more than one Google Service, you might want to use the same Google Client for authentication:

```edn
{:duct.services.google/client {:credentials-path "my-creds.json"}
 :duct.services.google/sheets {:client #ig/ref :duct.services.google/client}
 :duct.services.google/drive {:client #ig/ref :duct.services.google/client}}
```

## Building & testing this library

`lein test`

## License

Copyright © 2019 Yehonathan Sharvit

Distributed under the Eclipse Public License version 2.0
