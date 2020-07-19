#!/usr/bin/env groovy
package com.masterlib

class GlobalVars {
   static String foo = "bar"

   // refer to this in a pipeline using:
   //
   // import com.masterlib.GlobalVars
   // println GlobalVars.foo
}
