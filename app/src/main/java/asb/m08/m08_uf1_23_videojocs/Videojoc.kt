package asb.m08.m08_uf1_23_videojocs

import java.io.Serializable

class Videojoc (val titol: String, val imatge: Int, val jugadors: Int): Serializable
//Serializable permet que es pugui passar entre activities/fragments amb un intent.PutExtra
