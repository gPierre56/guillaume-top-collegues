# guillaume-top-collegues
Lien vers l'application : https://guillaume-top-collegues.herokuapp.com/collegue?nomCollegue=Turpin


Collection a importer sur postman  :

{
	"info": {
		"_postman_id": "5500a760-7912-4e2d-be31-3d1609b00846",
		"name": "API collegues",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Authentification administrateur",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"nomUtilisateur\" : \"john\",\n\t\"motDePasse\" : \"1234\"\n}"
				},
				"url": {
					"raw": "https://guillaume-top-collegues.herokuapp.com/auth",
					"protocol": "https",
					"host": [
						"guillaume-top-collegues",
						"herokuapp",
						"com"
					],
					"path": [
						"auth"
					]
				}
			},
			"response": []
		},
		{
			"name": "Authentification utilisateur",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"nomUtilisateur\" : \"jojo\",\n\t\"motDePasse\" : \"1234\"\n}"
				},
				"url": {
					"raw": "https://guillaume-top-collegues.herokuapp.com/auth",
					"protocol": "https",
					"host": [
						"guillaume-top-collegues",
						"herokuapp",
						"com"
					],
					"path": [
						"auth"
					]
				}
			},
			"response": []
		},
		{
			"name": "Authentification mauvais identifiants",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"nomUtilisateur\" : \"jofjo\",\n\t\"motDePasse\" : \"1234\"\n}"
				},
				"url": {
					"raw": "https://guillaume-top-collegues.herokuapp.com/",
					"protocol": "https",
					"host": [
						"guillaume-top-collegues",
						"herokuapp",
						"com"
					],
					"path": [
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "Déconnexion",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"nomUtilisateur\" : \"jofjo\",\n\t\"motDePasse\" : \"1234\"\n}"
				},
				"url": {
					"raw": "https://guillaume-top-collegues.herokuapp.com/logout",
					"protocol": "https",
					"host": [
						"guillaume-top-collegues",
						"herokuapp",
						"com"
					],
					"path": [
						"logout"
					]
				}
			},
			"response": []
		},
		{
			"name": "Rechercher collègue par nom",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "https://guillaume-top-collegues.herokuapp.com/collegue?nomCollegue=Pierre",
					"protocol": "https",
					"host": [
						"guillaume-top-collegues",
						"herokuapp",
						"com"
					],
					"path": [
						"collegue"
					],
					"query": [
						{
							"key": "nomCollegue",
							"value": "Pierre"
						}
					]
				},
				"description": "Nom disponibles :\n\nDoe\nDuff\nPierre\nTurpin\nPeyras"
			},
			"response": []
		},
		{
			"name": "Get utilisateur identifié",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://guillaume-top-collegues.herokuapp.com/auth/user",
					"protocol": "https",
					"host": [
						"guillaume-top-collegues",
						"herokuapp",
						"com"
					],
					"path": [
						"auth",
						"user"
					]
				}
			},
			"response": []
		}
	]
}

