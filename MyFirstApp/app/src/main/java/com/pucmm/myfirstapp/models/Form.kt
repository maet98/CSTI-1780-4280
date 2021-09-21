package com.pucmm.myfirstapp.models

import java.io.Serializable
import java.util.*

class Form  (
        var firstName: String,
        var lastName: String,
        var birthDate: String,
        var genre: String,
        var programming: Boolean,
        var languages: MutableList<String>
): Serializable {

    public fun addLanguage(language: String) {
        this.languages.add(language)
    }

    public fun removeLanguage(language: String) {
        this.languages.remove(language);
    }

    public override fun toString(): String {
        var ans = ""
        if ( this.birthDate.isEmpty()) {
            ans += "Hola!, mi nombre es: $firstName $lastName.\n" +
                    " \n" +
                    " Soy $genre  \n" +
                    "\n"
        } else {
            ans += "Hola!, mi nombre es: $firstName $lastName.\n" +
                    " \n" +
                    " Soy $genre, y naci en fecha $birthDate. \n" +
                    "\n"
        }
        if (this.programming) {
            ans += "Me gusta programar. Mis lenguajes favoritos son: ";
            for (lang in languages) {
                ans += "$lang, ";
            }
            ans += ".";
        }
        return ans;
    }
}