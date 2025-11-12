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