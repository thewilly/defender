![logo](https://github.com/thewilly/defender/blob/master/.github/DEFENDER_LOGO.png)


|| **Architecture** | **Status** |
|:------:|:-:|:----------:|
|**Ubuntu Trusty 14.04**|x86_64|[![Build Status](https://travis-ci.org/thewilly/defender.svg?branch=master)](https://travis-ci.org/thewilly/defender)|



Defender is a micro-service that allows you to store metadata for a given token in dynamodb. It works through REST requests/responses and it is build in java with spring boot.

## Getting started
Defender uses a key value database where the key represents the unique token for you metadata, that is stored in the value.

 - `key` | `token`: represents the unique identifier by which the metadata will be indexed. Implemented with a `String`.
 - `value` | `metadata`: it is implemented by a map of type `<String, Object>` so you can add more maps if necessary.

### How to interact with REST services
 As the only operations allowed are get the metadata associated with a cookie and store or update a cookie value this service uses `/` directory for all requests.

 #### GET
  - Needs from a token String at the payload as JSON and with the tag `token`.

  **Response:** The cookie metadata if found and the http status OK or the error.

 #### POST
  - Needs from a token String at the payload as JSON and with the tag `token`.
  - Needs a map metadata in the JSON payload with the tag `metadata`.

  **Behavior:** If the token is already registered it updates the value of the metadata. Else will just store the new cookie token and metadata.

  **Response:** The http status OK or the error.
