const express = require('express');
const cors = require('cors');
const mysql = require('mysql2');
const app = express()

const conn = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'ingatlan'
})

conn.connect(err => {
    if (err) {
        console.error('Database connection error:', err)
        return
    }
    console.log('Connected to database')
})

app.use(cors())
app.use(express.json())

app.get('/api/ingatlan', (req, res) => {
    const sql = 'SELECT ingatlanok.id, ingatlanok.leiras, ' +
                    'ingatlanok.hirdetesDatuma, ingatlanok.tehermentes, ' +
                    'ingatlanok.ar, ingatlanok.kepURL, ' +
                    'kategoriak.nev AS kategoria ' +
                'FROM ingatlanok ' +
                'LEFT JOIN kategoriak ON ' +
                    'ingatlanok.kategoria = kategoriak.id'
    conn.query(sql, (err, results) => {
        if (err) {
            console.warn(err)
            res.sendStatus(500)
            return
        } else {
            const refactoredResults = results.map(row => ({
                ...row, tehermentes: !!row.tehermentes,
                hirdetesDatuma: row.hirdetesDatuma.toISOString().slice(0, 10)
            }))
            res.status(200).json(refactoredResults)
        }
    })
})

app.post('/api/ingatlan', (req, res) => {
    console.log(req.body)

    res.status(201).json('TODO')
})

const port = 3333
app.listen(port, err => {
    if (err) console.warn(err)
    else console.log(`Server is running on port ${port}`)
})