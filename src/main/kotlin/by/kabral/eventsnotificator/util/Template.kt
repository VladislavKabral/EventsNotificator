package by.kabral.eventsnotificator.util

object Template {
  val BIRTHDAY = """
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
        <title>Напоминание о дне рождения</title>
        <style type="text/css">
            body, table, td, p, a, div, span {
                margin: 0;
                padding: 0;
                border: 0;
                font-size: 100%;
                font-family: 'Segoe UI', 'Helvetica Neue', Helvetica, Arial, sans-serif;
            }
            body {
                background-color: #f4f7fb;
                line-height: 1.5;
            }
            .email-container {
                max-width: 550px;
                margin: 0 auto;
                background-color: #ffffff;
                border-radius: 16px;
                overflow: hidden;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
            }
            .header {
                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                padding: 32px 24px;
                text-align: center;
                color: white;
            }
            .header h1 {
                font-size: 28px;
                font-weight: 700;
                margin-bottom: 8px;
                letter-spacing: -0.3px;
            }
            .header p {
                font-size: 16px;
                opacity: 0.95;
            }
            .content {
                padding: 40px 28px;
                background-color: #ffffff;
                text-align: center;
            }
            .birthday-card {
                background: linear-gradient(120deg, #fef9e6 0%, #fff4e0 100%);
                border-radius: 20px;
                padding: 32px 20px;
                text-align: center;
                border: 1px solid #ffe2b5;
            }
            .birthday-icon {
                font-size: 64px;
                margin-bottom: 16px;
            }
            .birthday-name {
                font-size: 34px;
                font-weight: 700;
                color: #2d3748;
                margin-bottom: 12px;
            }
            .birthday-badge {
                display: inline-block;
                background-color: #f56565;
                color: white;
                padding: 8px 20px;
                border-radius: 50px;
                font-size: 15px;
                font-weight: 600;
                margin-top: 8px;
            }
            .reminder-text {
                margin: 28px 0 0 0;
                font-size: 16px;
                color: #4a5568;
                line-height: 1.6;
            }
            .footer {
                background-color: #f9fafb;
                padding: 24px 28px;
                text-align: center;
                font-size: 13px;
                color: #718096;
                border-top: 1px solid #e2e8f0;
            }
            @media only screen and (max-width: 550px) {
                .content {
                    padding: 28px 20px;
                }
                .birthday-name {
                    font-size: 28px;
                }
                .header h1 {
                    font-size: 24px;
                }
            }
        </style>
    </head>
    <body style="background-color: #f4f7fb; padding: 20px 0;">
    <center style="width: 100%;">
        <div style="max-width: 550px; margin: 0 auto;">
            <div class="email-container">
                <div class="header">
                    <h1>🎉 Напоминание о дне рождения 🎂</h1>
                    <h5>${'$'}date день рождения отмечает:</h5>
                </div>
                <div class="content">
                    <div class="birthday-card">
                        <div class="birthday-icon">🎈🎁🎈</div>
                        <div class="birthday-name">${'$'}fullName</div>
                        <div class="birthday-badge">Сегодня день рождения! 🎂</div>
                    </div>
                    <div class="reminder-text">
                        <p style="margin-top: 12px;">✨  ${'$'}wish  ✨ </p>
                    </div>
                </div>
                <div class="footer">
                    <p style="margin-top: 8px;">© Владислав Кабраль</p>
                </div>
            </div>
        </div>
    </center>
    </body>
    </html>
  """.trimIndent()

  val MOTHERS_DAY = """
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
        <title>Напоминание о Дне матери</title>
        <style type="text/css">
            body, table, td, p, a, div, span {
                margin: 0;
                padding: 0;
                border: 0;
                font-size: 100%;
                font-family: 'Segoe UI', 'Helvetica Neue', Helvetica, Arial, sans-serif;
            }

            body {
                background-color: #fdf2f8;
                line-height: 1.5;
            }

            .email-container {
                max-width: 500px;
                margin: 0 auto;
                background-color: #ffffff;
                border-radius: 20px;
                overflow: hidden;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
            }

            .header {
                background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
                padding: 30px 20px;
                text-align: center;
                color: white;
            }

            .header h1 {
                font-size: 26px;
                font-weight: 700;
                margin-bottom: 6px;
            }

            .header p {
                font-size: 15px;
                opacity: 0.95;
            }

            .content {
                padding: 40px 24px;
                background-color: #ffffff;
                text-align: center;
            }

            .holiday-icon {
                font-size: 60px;
                margin-bottom: 20px;
            }

            .holiday-name {
                font-size: 28px;
                font-weight: 700;
                color: #9b2c2c;
                margin-bottom: 20px;
            }

            .reminder-text {
                font-size: 17px;
                color: #4a5568;
                line-height: 1.6;
            }

            .footer {
                background-color: #fff5f8;
                padding: 20px 24px;
                text-align: center;
                font-size: 12px;
                color: #a0526d;
                border-top: 1px solid #fce4ec;
            }

            @media only screen and (max-width: 500px) {
                .content {
                    padding: 28px 20px;
                }
                .holiday-name {
                    font-size: 24px;
                }
                .header h1 {
                    font-size: 22px;
                }
            }
        </style>
    </head>
    <body style="background-color: #fdf2f8; padding: 20px 0;">

    <center style="width: 100%;">
        <div style="max-width: 500px; margin: 0 auto;">
            
            <div class="email-container">
                
                <div class="header">
                    <h1>🌷 Напоминание 🌸</h1>
                    <p>Важное событие уже сегодня</p>
                </div>
                
                <div class="content">
                    <div class="holiday-icon">🌸💐🌺</div>
                    <div class="holiday-name">День матери</div>
                    <div class="reminder-text">
                        <p>Не забудьте поздравить своих мам.</p>
                        <p style="margin-top: 12px;">Звонок, тёплые слова или маленький сюрприз сделают этот день особенным.</p>
                    </div>
                </div>
                
                <div class="footer">
                    <p>© Владислав Кабраль</p>
                </div>
                
            </div>
            
        </div>
    </center>

    </body>
    </html>
  """.trimIndent()

  val WEDDING_ANNIVERSARY = """
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
        <title>Напоминание о годовщине свадьбы</title>
        <style type="text/css">
            body, table, td, p, a, div, span {
                margin: 0;
                padding: 0;
                border: 0;
                font-size: 100%;
                font-family: 'Segoe UI', 'Helvetica Neue', Helvetica, Arial, sans-serif;
            }

            body {
                background-color: #fef7e8;
                line-height: 1.5;
            }

            .email-container {
                max-width: 500px;
                margin: 0 auto;
                background-color: #ffffff;
                border-radius: 20px;
                overflow: hidden;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
            }

            .header {
                background: linear-gradient(135deg, #f5af19 0%, #f12711 100%);
                padding: 30px 20px;
                text-align: center;
                color: white;
            }

            .header h1 {
                font-size: 26px;
                font-weight: 700;
                margin-bottom: 6px;
            }

            .header p {
                font-size: 15px;
                opacity: 0.95;
            }

            .content {
                padding: 40px 24px;
                background-color: #ffffff;
                text-align: center;
            }

            .holiday-icon {
                font-size: 60px;
                margin-bottom: 20px;
            }

            .holiday-name {
                font-size: 28px;
                font-weight: 700;
                color: #c0392b;
                margin-bottom: 20px;
            }

            .couple-names {
                font-size: 26px;
                font-weight: 600;
                color: #e67e22;
                margin-bottom: 25px;
                padding: 15px 20px;
                background-color: #fef5e7;
                border-radius: 20px;
                display: inline-block;
                min-width: 200px;
            }

            .couple-names div {
                padding: 8px 0;
            }

            .couple-names .heart {
                font-size: 28px;
                color: #e74c3c;
                padding: 5px 0;
            }

            .reminder-text {
                font-size: 17px;
                color: #4a5568;
                line-height: 1.6;
            }

            .footer {
                background-color: #fef5e7;
                padding: 20px 24px;
                text-align: center;
                font-size: 12px;
                color: #b96f0f;
                border-top: 1px solid #fdebd0;
            }

            @media only screen and (max-width: 500px) {
                .content {
                    padding: 28px 20px;
                }
                .holiday-name {
                    font-size: 24px;
                }
                .couple-names {
                    font-size: 22px;
                    min-width: 160px;
                }
                .header h1 {
                    font-size: 22px;
                }
            }
        </style>
    </head>
    <body style="background-color: #fef7e8; padding: 20px 0;">

    <center style="width: 100%;">
        <div style="max-width: 500px; margin: 0 auto;">
            
            <div class="email-container">
                
                <div class="header">
                    <h1>💍 Напоминание 💒</h1>
                    <p>Важная дата уже сегодня</p>
                </div>
                
                <div class="content">
                    <div class="holiday-icon">💑💍💐</div>
                    <div class="holiday-name">${'$'}{'$'}{'$'}date годовщина свадьбы</div>
                    
                    <div class="couple-names">
                        <div>${'$'}{'$'}description 💕</div>
                    </div>
                    
                    <div class="reminder-text">
                        <p>Не забудьте поздравить эту прекрасную пару.</p>
                        <p style="margin-top: 12px;">Тёплые пожелания, цветы и внимание сделают этот день ещё более особенным.</p>
                    </div>
                </div>
                
                <div class="footer">
                    <p>© Владислав Кабраль</p>
                </div>
                
            </div>
            
        </div>
    </center>

    </body>
    </html>
  """.trimIndent()

  val UNIVERSAL = """
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
        <title>Напоминание о событии</title>
        <style type="text/css">
            body, table, td, p, a, div, span {
                margin: 0;
                padding: 0;
                border: 0;
                font-size: 100%;
                font-family: 'Segoe UI', 'Helvetica Neue', Helvetica, Arial, sans-serif;
            }

            body {
                background-color: #e8f0fe;
                line-height: 1.5;
            }

            .email-container {
                max-width: 500px;
                margin: 0 auto;
                background-color: #ffffff;
                border-radius: 20px;
                overflow: hidden;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
            }

            .header {
                background: linear-gradient(135deg, #3b82f6 0%, #8b5cf6 100%);
                padding: 30px 20px;
                text-align: center;
                color: white;
            }

            .header h1 {
                font-size: 26px;
                font-weight: 700;
                margin-bottom: 6px;
            }

            .header p {
                font-size: 15px;
                opacity: 0.95;
            }

            .content {
                padding: 40px 24px;
                background-color: #ffffff;
                text-align: center;
            }

            .event-icon {
                font-size: 60px;
                margin-bottom: 20px;
            }

            .event-name {
                font-size: 28px;
                font-weight: 700;
                color: #1e40af;
                margin-bottom: 20px;
            }

            .recipients {
                font-size: 22px;
                font-weight: 500;
                color: #4b5563;
                margin-bottom: 25px;
                padding: 12px 20px;
                background-color: #f3f4f6;
                border-radius: 16px;
                display: inline-block;
                min-width: 200px;
            }

            .recipients div {
                padding: 4px 0;
            }

            .reminder-text {
                font-size: 17px;
                color: #4a5568;
                line-height: 1.6;
            }

            .footer {
                background-color: #f0f4fa;
                padding: 20px 24px;
                text-align: center;
                font-size: 12px;
                color: #5b677b;
                border-top: 1px solid #e2e8f0;
            }

            @media only screen and (max-width: 500px) {
                .content {
                    padding: 28px 20px;
                }
                .event-name {
                    font-size: 24px;
                }
                .recipients {
                    font-size: 18px;
                    min-width: 160px;
                }
                .header h1 {
                    font-size: 22px;
                }
            }
        </style>
    </head>
    <body style="background-color: #e8f0fe; padding: 20px 0;">

    <center style="width: 100%;">
        <div style="max-width: 500px; margin: 0 auto;">
            
            <div class="email-container">
                
                <div class="header">
                    <h1>📅 Напоминание 📌</h1>
                    <p>Важное событие уже сегодня</p>
                </div>
                
                <div class="content">
                    <div class="reminder-text">
                        <p>${'$'}{'$'}date</p>
                    </div>
                    
                    <div class="event-name">${'$'}{'$'}name</div>
                    
                    <div class="reminder-text">
                        <p>${'$'}{'$'}description</p>
                    </div>
                </div>
                
                <div class="footer">
                    <p>© Владислав Кабраль</p>
                </div>
                
            </div>
            
        </div>
    </center>

    </body>
    </html>
  """.trimIndent()
}