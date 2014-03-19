## An opinionated web application skeleton in Clojure

MVC web application skeleton, written in Clojure with user management and nice theme.

Language: Clojure

Web framework: Compojure

Javascript: JQuery

Graphing: Flot

Layout: Bootstrap

Database: PostgreSQL, via Korma

## How to make it your own

- CD to wherever you keep your projects
```
cd ~/dev/clojure-projects
```

- Download init script
```
curl https://raw.githubusercontent.com/anonymoose/clojure-skeleton/master/init > init
chmod +x init
```

- Name your project.  We'll call it "fish" for now.

- Run the script
```
./init fish
```

- Start up a browser to [http://localhost:5000](http://localhost:5000)

## Where is everything?
- Entry point - src/$yourproject$/core.clj
- Controllers - src/$yourproject$/controller
- Model - src/$yourproject$/model
- Routing - src/$yourproject$/controller/routes.clj
- DB schema - doc/schema.sql

## How do I develop?
- CD to your project root
- Execute dev script:
```
> bin/dev
main INFO  log.MLog - MLog clients using log4j logging.
 
2014-03-19 16:19:00.494:INFO:oejs.Server:jetty-7.6.8.v20121106

2014-03-19 16:19:00.529:INFO:oejs.AbstractConnector:Started SelectChannelConnector@0.0.0.0:5000
Started server on port 5000
```
- Make changes to your files.  They are automatically reloaded via Ring's "auto-reload?" param in project.clj.  It's not perfect, but its pretty close.

## How do I start up the REPL with everything accessible?
- Fire up "lein repl" or other mechanism in Emacs or whatever.
```
04:32 PM|kb|~/dev/clojuredev/clojure-skeleton> lein repl
myproject.core=> (load-file "doc/repl.clj")
"ready."
myproject.core=> (re)
"ready."
myproject.core=> 
```
- When you make a change in your files, just run "(re)" to reload everything.
- Read the contents of doc/repl.clj and add to taste as your project progresses.

## Where are the templates?
- resources/templates/*.html
- Templates use [Selmer](https://github.com/yogthos/Selmer).  It's pretty great if you like to get done and on with your life.  If you like to fight with things go use Enlive or something else.  I'm not smart enough.

## What is this theme?
- http://startbootstrap.com/sb-admin
- Change it up.  This is a starting point.  If I see 200 of these out on the web with no modification I'm going to be pissed.

## How do I change the schema?
- Make changes in doc/schema.sql 
- bin/reset-schema

## License

Copyright &copy; 2014 Palm Valley Software

Distributed under the Eclipse Public License, the same as Clojure.
