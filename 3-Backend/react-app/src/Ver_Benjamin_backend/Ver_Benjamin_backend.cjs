const express = require('express');
const cors = require('cors');
const app = express()

app.use(cors())
app.use(express.json())



const port = 3333
app.listen(port, err => {
    if (err) console.warn(err)
    else console.log(`Server is running on port ${port}`)
})

app.get('/api/ingatlan', (req, res) => {
    const sql = 'SELECT ingatlanok.id, ingatlanok.kategoria, ingatlanok.leirar, ' +
                    'ingatlanok.hirdetesDatuma, ingatlanok.tehermentes, ' +
                    'ingatlanok.ar, ingatlanok.kepURL, ' +
                'FROM ingatlanok ' +
                'LEFT JOIN kategoriak ON ' +
                    'ingatlanok.kategoria = kategoriak.id'
    conn.query(sql, (err, results) => {
        if (err) {
            console.warn(err)
            res.sendStatus(500)
            return
        } else {
            console.log(results)
            res.sendStatus(200).json(result)
        }
    })
})