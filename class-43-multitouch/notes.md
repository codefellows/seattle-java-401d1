blocking - prevents other code from running
non-blocking - allows other code to run

synchronous - blocking
asynchoronous - non-blocking

parallel/concurrent - things running at the same time

thread - some code running from start to finish

single-threaded - only one thing ever happens at a time
multi-threaded - multiple things occur simultaneously

public String reverse(String str) {
  if (str.length() <= 1) {
    return str;
  }
  return reverse(str.substring(1)) + str.charAt(0);
}

reverse(quora)
  reverse(uora) + "q"
    reverse(ora) + "u"
      reverse(ra) + "o"
        reverse(a) + "r"
          return "a"
        "a" + "r"
      "ar" + "o"
    "aro" + "u"
  "arou" + "q"
"arouq"
 
