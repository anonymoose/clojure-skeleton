## An opinionated web application skeleton in Clojure

MVC web application skeleton, written in Clojure with user management and nice theme.

Language: Clojure

Web framework: Compojure

Javascript: JQuery

Graphing: Flot

Layout: Bootstrap

Database: PostgreSQL, via Korma

## How do I make it my own?

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

## What the hell just happened?
You ran a script blind off the internet.  Don't do that.  All it did was:

1. Cloned everything for this project from git.

2. Renamed the directory and all references to "myproject" to your project name.

3. Created a database and set up security settings only suitable for a dev environment.  If you run with your password 
the same as your project name in production, you are an idiot.

4. Creates a bin/.password file to hold your passwords so scripts work locally.

5. Removes clojure-skeleton's git directory and initializes a git repo.

6. Initial commit

7. Starts up the app on http://localhost:5000

## Wow, I'm basically done!  How do I put it on Heroku?
- You're not done, but this may have saved you a week.
- [https://devcenter.heroku.com/articles/clojure-web-application](Good article on putting clojure apps on Heroku)

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

## But wait, I've only got Windows!
I am lucky enough to have Mac.  If I get time I'll extend this to Windows.  Now fielding pull requests...

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
