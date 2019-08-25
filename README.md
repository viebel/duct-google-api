# Duct services.google-api

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

### Without a separate Google Client

For Drive service:

```edn
{:duct.services.google/drive
  {:credential-path "my-creds.json"
   :application-name "my-app"
   :scopes [:drive]}}
```

For Sheets service:

```edn
{:duct.services.google/sheets
  {:credential-path "my-creds.json"
   :application-name "my-app"
   :scopes [:sheets}}}}
```

### With a separate Google Client

When you need more than one Google Service, you might want to use the same Google Client for authentication:

```edn
{:duct.services.google/client {:credential-path "my-creds.json"
                               :application-name "my-app"
                               :scopes [:drive :sheets}}}
 :duct.services.google/sheets {:client #ig/ref :duct.services.google/client}
 :duct.services.google/drive {:client #ig/ref :duct.services.google/client}}
```

## Building & testing this library

`lein test`

## License

Copyright © 2019 Yehonathan Sharvit

Distributed under the Eclipse Public License version 2.0
