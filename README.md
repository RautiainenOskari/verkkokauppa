# verkkokauppa
Backend kurssi projekti -Oskari Rautiainen

About: Verkkokauppa eri teknologian tuotteille.

Ominaisuudet:
1. Tuotteiden listaaminen.
2. Tuotteiden lisääminen, muokkaaminen ja poistaminen.
3. Valmistajien listaaminen (Valmistaja on OneToMany).
4. Valmistajien lisääminen, muokkaaminen ja poistaminen.

5. Kaikki käyttäjien syötteet on validoitu kuvia lukuunottamatta.
6. Login ominaisuus admin roolilla. (username = admin, password = salasana).
7. Ainoastaan admin voi lisätä, muokata ja poistaa asioita, normaali käyttäjä ei myöskään pysty näkemään valmistajien listaa.
8. REST ominaisuuksia, pystyy listaamaan tuotteet ja valmistajat (/tuotteet, /tuote/{id}, /valmistajatRest, /valmistaja/{id}.
9. Kuvat lisätään projektin /static/kuvat kansioon
